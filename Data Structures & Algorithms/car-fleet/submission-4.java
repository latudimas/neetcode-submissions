class Solution {
    private record Entry(int position, int speed, double time) {}

    public int carFleet(int target, int[] position, int[] speed) {
        // what we know so far:
        // posiition (array)
        // speed (array) 1:1 dengan position
        // target -> finish line, or final position

        //rules:
        // - car cannot pass another car ahead
        // - if it catchup the front cars, it merge into fleet

        // goal
        // number of different car fleets

        // distance from ith car to target: target - position[i]
        // times to reach the target from ith position = distance/speed

        // reduction
        // kalau t (times) is bigger than t in the front. no catchup
        // kalau t[i] lebih kecil atau sama dengan t in the front, bisa catchup dan join fleet
        
        List<Entry> carData = new ArrayList<>();

        // fill the data
        for (int i = 0; i < position.length; i++) {
            double timeToTarget = (double) (target - position[i]) / speed[i];
            carData.add(new Entry(position[i], speed[i], timeToTarget));  
        }

        // mutate the list, sort by position in descending order
        carData.sort((a, b) -> Integer.compare(b.position(), a.position()));
        // System.out.println(carData);
        
        Double fleetAheadTime = null;
        // key -> time   val -> counter of fleet member
        Map<Double,Integer> fleet = new HashMap<>();

        for(Entry entry: carData) {
            if(fleetAheadTime == null) {
                fleetAheadTime = entry.time();
                fleet.put(fleetAheadTime, 1);
            } else if (entry.time() <= fleetAheadTime){
                int existingCounter = fleet.get(fleetAheadTime);
                fleet.put(fleetAheadTime, existingCounter++);
            } else {
                fleetAheadTime = entry.time();
                fleet.put(fleetAheadTime, 1);
            }
        }

        return fleet.size();
    }
}
