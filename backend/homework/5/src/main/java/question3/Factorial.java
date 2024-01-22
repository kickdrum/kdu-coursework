package question3;

class Factorial extends Thread {
    private int number;
    private long factorial;
    public Factorial(int number) {
        this.number = number;
        this.factorial = 1;
    }
    public long getFactorial() {
        return factorial;
    }

    @Override
    public void run() {
        calculateFactorial();
    }

    private void calculateFactorial() {
        for (int i = 1; i <= number; i++) {
            factorial *= i;
        }
    }
}
