class Solution {
     public static int maximumUnits(int[][] boxTypes, int truckSize) {

        List<Box> list = new ArrayList<>();
        for (int i = 0; i < boxTypes.length; i++) {
            list.add(new Box(boxTypes[i][1], boxTypes[i][0]));
        }

        Collections.sort(list, new Comparator<Box>() {
            @Override
            public int compare(Box o1, Box o2) {
                return o2.unit-o1.unit;
            }
        });

      // list.forEach(e->System.out.println(e.unit));
        int sum = 0;
        int boxAdded = 0;

            for(int i=0;i<list.size();i++){

            int units = list.get(i).unit;
            int boxs = list.get(i).box;

            if (boxAdded < truckSize) {
                int diff = truckSize - boxAdded;

                if (diff > boxs) {
                    sum += boxs * units;
                    boxAdded += boxs;
                } else {
                    sum += diff * units;
                    boxAdded += diff;
                }
            }
            if (truckSize == boxAdded)
                break ;
        }
        return sum;
    }
}

class Box{
    int box;
    int unit;

    public Box( int unit, int box) {
        this.box = box;
        this.unit = unit;
    }
}
