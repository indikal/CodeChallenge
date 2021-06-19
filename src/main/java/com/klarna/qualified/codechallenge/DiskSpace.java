package com.klarna.qualified.codechallenge;

import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DiskSpace {

  public static boolean isWritable(int blockSize, int fileSize, Set<Integer> occupiedSectors) {
    if (!isBlockCanHoldTheFile(blockSize, fileSize)) {
      //initial validation of block size with file sizes
      return false;
    } else if (occupiedSectors.isEmpty()) {
      //block can hold the file and no sectors occupied
      return true;
    } else {
      return isFileFitIntoBlock(occupiedSectors, blockSize, fileSize);
      //return getFreeContiguousBlockSize(occupiedSectors, fileSize, blockSize) > fileSize;
    }
  }

  /**
   * Check whether any contiguous blocks size fits with the file size
   * @param occupied a Set of occupied sectors
   * @param blockSize the whole block size
   * @param fileSize the given file size
   * @return whether the file can be stored in the given block
   */
  private static boolean isFileFitIntoBlock(Set<Integer> occupied, int blockSize, int fileSize) {
    //.map(s -> new AbstractMap.SimpleEntry<>(s, s.length()))
    int[] allSectorsInBlock = IntStream.rangeClosed(1, blockSize).toArray();

    AtomicInteger nextFreeSector = new AtomicInteger(1);
    List<Integer> lengthOfFreeSectors = occupied.stream()
        .map(occupiedSector -> (occupiedSector - nextFreeSector.getAndSet(occupiedSector + 1)))
        .filter(freeBlockSize -> freeBlockSize > 0)
        .collect(Collectors.toList());

    if (blockSize >= nextFreeSector.incrementAndGet()) {
      lengthOfFreeSectors.add((blockSize - nextFreeSector.get()) + 1);
    }

    return lengthOfFreeSectors.stream()
        .anyMatch(freeSize -> freeSize >= fileSize);
  }

  /**
   * Check whether the given block can hold the file
   * @param blockSize given block size
   * @param fileSize given file size
   * @return if file can place in the block
   */
  private static boolean isBlockCanHoldTheFile(int blockSize, int fileSize) {
    return blockSize >= fileSize;
  }

  /**
   * Get the free contiguous block size where the file can be fit into
   * @param occupiedSectors occupied sectors in the given block
   * @param fileSize given file size
   * @return free contiguous block size where the file can be fit into
   */
  private static int getFreeContiguousBlockSize(Set<Integer> occupiedSectors, int fileSize, int blockSize) {
    Integer[] occupied = occupiedSectors.toArray(new Integer[0]);

    for (int i=0; i<occupied.length; i++) {
      int start = occupied[i];

      if (i < (occupied.length - 1)) {
        int next = occupied[i + 1];
        int freeSize = next - start;

        if (isFileFitToFreeSpace(fileSize, freeSize)) {
          return freeSize;
        }
      }
    }

    //check space beyond last occupied sector
    int lastSectorOccupied = occupied[occupied.length - 1];
    if (blockSize > lastSectorOccupied) {
      int freeSize = blockSize - lastSectorOccupied;
      if (isFileFitToFreeSpace(fileSize, freeSize)) {
        return freeSize;
      }
    }

    return -1;
  }

  private static boolean isFileFitToFreeSpace(int fileSize, int freeSize) {
    return (freeSize >= fileSize);
  }
}
