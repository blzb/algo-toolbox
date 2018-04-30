import java.util.*;

public class LCM {
  private static long lcm_naive(long a, long b) {
    long base = a;
    long current_gcd = b;
    while((base%current_gcd) != 0){
      long tmp = base%current_gcd;
      base=current_gcd;
      current_gcd=tmp;
    }
    return (a*b)/current_gcd;
  }

  public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);
    int a = scanner.nextInt();
    int b = scanner.nextInt();

    System.out.println(lcm_naive(a, b));
  }
}
