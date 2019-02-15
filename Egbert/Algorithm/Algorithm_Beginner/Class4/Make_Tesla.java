class Tesla {
	int numOfWheels;
	int vin;
	public Tesla(int n, int v) {
		numOfWheels = n;
		vin = v;
	}
}

class Accumulator {
	public Tesla[] make(int n) {
    Tesla[] telsas = new Tesla[n];
    for (int i = 0; i < n; i++) {
      telsas[i] = new Tesla(4, i); 
    }
    return telsas;
	}
}
