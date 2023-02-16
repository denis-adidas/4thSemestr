public class fraction {
    private int numerator; //числитель
    private int detonominator; //знаменатель

    public fraction(int num, int det) {
        this.numerator = num;
        this.detonominator = det;
    }
    public fraction add(fraction a) {
        if (this.detonominator == a.detonominator) {
            this.numerator += a.numerator;
            return this;
        }
        else {
            int b = this.detonominator;
            this.detonominator *= a.detonominator;
            this.numerator *= a.detonominator;
            a.numerator *= b;
            a.detonominator *= b;
            this.numerator += a.numerator;

            return this;
        }
    }
    public fraction mul(fraction a) {
        this.numerator *= a.numerator;
        this.detonominator *= a.detonominator;
        return this;
    }
    public void setDetonominator(int detonominator) {
        this.detonominator = detonominator;
    }
    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }
    public int getNumerator() {
        return numerator;
    }
    public int getDetonominator() {
        return detonominator;
    }
    public void out() {
        System.out.println(this.numerator + "/" + this.detonominator);
    }
}
