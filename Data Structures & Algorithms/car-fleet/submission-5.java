class Solution {
    private record Entry(int position, double time) {}

    public int carFleet(int target, int[] position, int[] speed) {
        
        List<Entry> cars = new ArrayList<>();

        // fill the data
        for (int i = 0; i < position.length; i++) {
            double timeToTarget = (double) (target - position[i]) / speed[i];
            cars.add(new Entry(position[i], timeToTarget));  
        }

       // mutate the list, sort by position in descending order
        cars.sort((a, b) -> Integer.compare(b.position(), a.position()));
        
        int fleetCount = 0;
        Double fleetAheadTime = 0.0;

        for(Entry car: cars) {
            if (fleetCount == 0 || car.time() > fleetAheadTime) {
                fleetCount++;
                fleetAheadTime = car.time();
            }
        }

        return fleetCount;
    }
}
