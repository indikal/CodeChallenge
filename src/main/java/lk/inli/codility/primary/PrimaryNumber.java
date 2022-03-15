package lk.inli.codility.primary;

public class PrimaryNumber {

  public int divisor(int n) {
    int i = 1;
    int result = 0;

    while ((i * i) < n) {
      if (n % i == 0) {
        result += 2;
      }
      i += 1;
    }

    if ((i * i) == n) {
      result += 1;
    }

    return result;
  }

  public boolean isPrimary(int n) {
    int i = 2;

    while ((i * i) <= n) {
      if (n % i == 0) {
        return false;
      }
      i += 1;
    }

    return true;
  }
}
