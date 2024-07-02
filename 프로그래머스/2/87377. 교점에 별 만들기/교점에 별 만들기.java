import java.util.*;

class Solution {
    public String[] solution(int[][] line) {
        List<Point> pointList = new ArrayList<>();
        int lineLength = line.length;
        for (int i = 0; i < lineLength; i++) {
            for (int j = i+1; j < lineLength; j++) {
                Point point = intersection(line[i][0], line[i][1], line[i][2],
                                          line[j][0], line[j][1], line[j][2]);
                if (point == null) {
                    continue;
                }
                
                pointList.add(point);
            }    
        }
        
        Point maximumPoint = getMaximumPoint(pointList);
        Point minimumPoint = getMinimumPoint(pointList);
        
        int width = (int) (maximumPoint.x - minimumPoint.x + 1);
        int height = (int) (maximumPoint.y - minimumPoint.y + 1);
        
        char[][] arr = new char[height][width];
        for (char[] row : arr) {
            Arrays.fill(row, '.');
        }
        
        for (Point point : pointList) {
            int x = (int) (point.x - minimumPoint.x);
            int y = (int) (maximumPoint.y - point.y);
            arr[y][x] = '*';
        }
        
        String[] answer = new String[arr.length];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = new String(arr[i]);
        }
        
        return answer;
    }
    
    private static class Point {
        public final long x;
        public final long y;
        
        private Point(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }
    
    private Point intersection(long a1, long b1, long c1, long a2, long b2, long c2) {
        double x = (double) (b1 * c2 - b2 * c1) / (a1 * b2 - a2 * b1);
        double y = (double) (a2 * c1 - a1 * c2) / (a1 * b2 - a2 * b1);
        if (x % 1 != 0 || y % 1 != 0) {
            // 정수가 아닐 경우
            return null;
        }
        
        return new Point((long) x, (long) y);
    }
    
    private Point getMinimumPoint(List<Point> pointList) {
        long x = Long.MAX_VALUE;
        long y = Long.MAX_VALUE;
        
        for (Point point : pointList) {
            if (point.x < x) x = point.x;
            if (point.y < y) y = point.y;
        }
        
        return new Point(x, y);
    }
    
    private Point getMaximumPoint(List<Point> pointList) {
        long x = Long.MIN_VALUE;
        long y = Long.MIN_VALUE;
        
        for (Point point : pointList) {
            if (point.x > x) x = point.x;
            if (point.y > y) y = point.y;
        }
        
        return new Point(x, y);
    }
    
}