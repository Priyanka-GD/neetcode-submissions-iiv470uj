class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        List<Cars> carsList = new ArrayList<>();
        for(int idx = 0; idx < position.length; idx++){
            carsList.add(new Cars(position[idx], speed[idx]));
        }
        Collections.sort(carsList);
        double lastArrivalTime = 0;
        int fleet = 0;

        for(Cars car : carsList){
            double arrivalT = (target - car.position)/ (double) car.speed;
            if(arrivalT > lastArrivalTime){
                fleet++;
                lastArrivalTime = arrivalT;
            }

        }
        return fleet;
    }
}
class Cars implements Comparable<Cars>{
    int position;
    int speed;

    public Cars(int p, int s){
        this.speed = s;
        this.position = p;
    }

    @Override
    public int compareTo(Cars others){
        return others.position - this.position;
    }
}
