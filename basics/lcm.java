 public int gcd(int A, int B){
    if( B == 0)
        return A;
    else 
        return gcd(B, A % B);
}
public int lcm(int a, int b) {
    return (a * b) / gcd(a, b);
}
