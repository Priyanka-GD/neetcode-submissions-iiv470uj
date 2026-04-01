class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        Car[] cars = new Car[n];

        for (int i = 0; i < n; i++) {
            cars[i] = new Car(position[i], speed[i]);
        }
        //Sorted array based on position of car
        Arrays.sort(cars);

        int fleetsCount = 0;
        double lastCarArrivalTime = 0;

        for (Car car : cars) {
            double arrivalTime = (target - car.position) / (double) car.speed;

            if (arrivalTime > lastCarArrivalTime) {
                fleetsCount++; // new fleet formed
                lastCarArrivalTime = arrivalTime;
            }
        }

        return fleetsCount;
    }

    private class Car implements Comparable<Car> {
        public int position;
        public int speed;

        public Car(int position, int speed) {
            this.position = position;
            this.speed = speed;
        }

        @Override
        public int compareTo(Car other) {
            return other.position - this.position;
        }
    }
}