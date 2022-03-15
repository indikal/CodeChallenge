package lk.inli.codility.caterpillar;

/*
Problem: You are given n sticks (of lengths 1 <= a0 <= a1 <= ... <= an−1 <= 10^9). The goal is
to count the number of triangles that can be constructed using these sticks. More precisely,
we have to count the number of triplets at indices x<y<z, such that ax + ay > az.
 */
public class Triangles {

  public int solution(int[] A) {
    int n = A.length;
    int noOfTriangles = 0;

    for (int x = 0; x < n; x++) {
      int z = x + 2;

      for (int y = x + 1; y < n; y++) {
        while ((z < n && (A[x] + A[y]) < A[z])) {
          z += 1;
        }
        noOfTriangles += z - y - 1;
      }
    }

    return noOfTriangles;
  }
}
