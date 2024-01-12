package question3;

class Factors extends Thread {
    private int number;
    private String factors;
    public Factors(int number) {
        this.number = number;
        this.factors = "";
    }
    public String getFactors() {
        return factors;
    }

    @Override
    public void run() {
        calculateFactors();
    }

    private void calculateFactors() {
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                factors += i + " ";
            }
        }
    }
}
