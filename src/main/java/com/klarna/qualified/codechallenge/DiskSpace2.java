package com.klarna.qualified.codechallenge;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DiskSpace2 {

  public static boolean isWritable(int blockSize, int fileSize, Set<Integer> occupiedSectors) {
    if (!isBlockCanHoldTheFile(blockSize, fileSize)) {
      //initial validation of block size with file sizes
      return false;
    } else if (occupiedSectors.isEmpty()) {
      //block can hold the file and no sectors occupied
      return true;
    } else {
      return isFileFitIntoUnoccupiedBlock(occupiedSectors, blockSize, fileSize);
    }
  }

  /**
   * Check whether any contiguous blocks size fits with the file size
   * @param occupied a Set of occupied sectors
   * @param blockSize the whole block size
   * @param fileSize the given file size
   * @return whether the file can be stored in the given block
   */
  private static boolean isFileFitIntoUnoccupiedBlock(Set<Integer> occupied, int blockSize, int fileSize) {
    occupied = sortCollection(occupied);

    int nextSectorToCheck = 1;
    for (int sector: occupied) {
      if (isContiguousUnoccupiedSectorsFitWithFileSize(nextSectorToCheck, sector, fileSize)) {
        System.out.println("Occupied Sector: " + sector + ", Next sector: " + nextSectorToCheck);
        return Boolean.TRUE;
      }
      nextSectorToCheck = sector + 1;
    }

    //now all sectors up to the last occupied sector were checked. We still need to check the
    //trailing sectors from last occupied sector to last sector in the block
    if (nextSectorToCheck <= blockSize) {
      System.out.println("Next unoccupied sector: " + nextSectorToCheck);
      //We need 'next occupied sector' as the endSector so will consider one sector beyond the given
      //block size ie. (blockSize + 1)
      return isContiguousUnoccupiedSectorsFitWithFileSize(
          nextSectorToCheck, (blockSize + 1), fileSize);
    }

    //default return: file cannot fit into block
    return Boolean.FALSE;
  }

  /**
   * Check if the unoccupied block fit into the file
   * @param startSector expected unoccupied start sector
   * @param endSector expected unoccupied end sector
   * @param fileSize expected file size to be stored
   * @return whether given file size can be stored
   */
  private static boolean isContiguousUnoccupiedSectorsFitWithFileSize(int startSector,
      int endSector, int fileSize) {
    return (endSector - startSector) >= fileSize;
  }

  /**
   * Sort the Set
   * @param occupied a Set of occupied sectors
   * @return sorted Set
   */
  private static Set<Integer> sortCollection(Set<Integer> occupied) {
    return occupied.stream()
        .parallel()
        .sorted()
        .collect(Collectors.toCollection(LinkedHashSet::new));
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

  private static boolean isFileFitToFreeSpace(int fileSize, int freeSize) {
    return (freeSize >= fileSize);
  }
}
