public class Int {
    private int value;
    public void increment() {
        this.value++;
    }
    public void decrement() {
        this.value--;
    }
    public int add(Int n) {
        return this.value + n.value;
    }

    public int substract(Int n) {
        return this.value - n.value;
    }
    public String toStr() {
        return "" + value;
    }
    public void set(int value) {
        this.value = value;
    }
    public void out() {
        System.out.println(this.value);
    }
}
