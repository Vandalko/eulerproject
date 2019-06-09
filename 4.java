

public class Four {


  public static void notMain(final String[] args) {
    System.out.println(Long.toBinaryString(123));
    System.out.println(Long.toBinaryString(Long.rotateLeft(123, 1)));
    System.out.println(Long.toBinaryString(Long.rotateRight(123, 1)));

  }
  
  public static void main(final String[] args) {
    final int minNum = 100;
    final int maxNum = 999;
    final int maxPal = maxNum * maxNum;
    
    long max = minNum * minNum;
    long pal = Four.isPalindrome(max) ? max : Four.nextPalindrome(max, false);
    while (pal <= maxPal) {
      for (int i = minNum; i <= maxNum; i++) {
        if (pal % i == 0) {
          final int div = (int) (pal / i);
          if (div >= minNum && div <= maxNum) {
            if (max < pal) {
              max = pal;
              System.out.println(i + " * " + div + " = " + pal);
            }
          }
        }
      }
      pal = Four.nextPalindrome(pal);
    }
  }


  static void printResult(final int caseNumber, final long result) {
    System.out.println("Case #" + caseNumber + ": " + result);
  }
  static void printResult(final int caseNumber, final String result) {
    System.out.println("Case #" + caseNumber + ": " + result);
  }

  static long nextPalindrome(final long base) {
    return Four.nextPalindrome(base, true);
  }

  static long nextPalindrome(final long base, final boolean increment) {
    if (base < 9) { return base + 1; }
    if (base == 9) { return 11; }
    
    final int digits = Four.digitsNum(base);
    final int halfDigits = digits >> 1;
    
    if (digits - halfDigits == halfDigits) {
      final long tens = decPow(halfDigits);
      final long mainPart = base / tens + (increment ? 1 : 0);
      if (Four.digitsNum(mainPart) == halfDigits) {
        return mainPart * tens + Four.reverse(mainPart);
      }
      return mainPart * tens + Four.reverse(mainPart / 10);
    }
    
    final long tens = decPow(halfDigits);
    long mainPart = base / tens;
    int middle = (int) (mainPart % 10);
    mainPart = mainPart / 10;
    if (middle < 9) {
      if (increment) { middle++; }
      return mainPart * tens * 10 + middle * tens + Four.reverse(mainPart);
    }
    if (increment) { mainPart++; }
    return mainPart * tens * 10 + Four.reverse(mainPart);
  }

  static long reverse(final long number) {
    if (number <= 9) { return number; }
    long result = 0;
    long num = number;
    while (num > 0) {
      final long rem = num % 10;
      result = result * 10 + rem;
      num = num / 10;
    }
    return result;
  }

  static boolean isPalindrome(final long number) {
    if (number <= 9) { return true; }
    return number == Four.reverse(number);
  }
  
  static int digitsNum(final long number) {
    return 1 + (int) Math.log10(number);
  }
  
  static long decPow(final int pow) {
    if (pow <= 9) { return smallDecPow(pow); }
    int left = pow / 2;
    return smallDecPow(left) * smallDecPow(pow - left);
  }
  
  static long smallDecPow(int pow) {
    switch (pow) {
    case 0: return 1;
    case 1: return 10;
    case 2: return 100;
    case 3: return 1000;
    case 4: return 10000;
    case 5: return 100000;
    case 6: return 1000000;
    case 7: return 10000000;
    case 8: return 100000000;
    case 9: return 1000000000;
    default:
      return decPow(pow);
    }
  }

}
