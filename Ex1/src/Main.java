public int Ulam(int n){
    while (n != 1) {
        if (n % 2 == 0) {
            n = n / 2;
        } else if (n % 2 != 0 && n != 1){
            n = (n * 3) + 1;
        }
        System.out.println(n);
    }
    return n;
}


public void main(String[] args) {
    int n = 10000000; //Specify n for testing Ulam method
    System.out.println("Your n: " + n + " is now after ULAM: " + Ulam(n));

}

