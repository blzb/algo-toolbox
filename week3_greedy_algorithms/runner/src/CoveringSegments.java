import java.util.*;

public class CoveringSegments {

    private static int[] optimalPoints(Segment[] segments) {
        //write your code here

        Arrays.sort(segments, (o1, o2) -> Integer.compare(o1.end, o2.end));

        List<Integer> points = new ArrayList<>();
        int lastPoint = segments[0].end;
        points.add(lastPoint);
        for(int i =1 ; i< segments.length; i++){
            if(!segments[i].inSegment(lastPoint)){
                lastPoint = segments[i].end;
                points.add(lastPoint);
            }
        }
        int [] p = new int[points.size()];
        for(int j = 0; j < points.size(); j++){
            p[j] = points.get(j);
        }
        return p;
    }

    private static class Segment {
        int start, end;
        int length;
        Segment(int start, int end) {
            this.start = start;
            this.end = end;
            this.length = end - start;
        }
        boolean inSegment(int point){
            return point >= this.start && point <= this.end;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Segment[] segments = new Segment[n];
        for (int i = 0; i < n; i++) {
            int start, end;
            start = scanner.nextInt();
            end = scanner.nextInt();
            segments[i] = new Segment(start, end);
        }
        int[] points = optimalPoints(segments);
        System.out.println(points.length);
        for (int point : points) {
            System.out.print(point + " ");
        }
    }
}
 
