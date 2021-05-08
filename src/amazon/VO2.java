//package amazon;
//
//public class VO2 {
//}
//
//
//
//
///*
//Interval - start time, end time, type of interval - work/break , day
//Map<>
//list of break
//list of work
//
//start time: 8,
//end time: 11
//
//start: [8]
//end: [11]
//
//Hash Map{dayof the month , {List of Break Intervals, List of Work Intervals}
//- Maximum hours an employee can work without break is 5
//- total number of breaks in a day  cannot be more than 3
//
//<1, {Work-> {[start:8, end: 4]}, Break->{[start:11, end:12]}},
// 2, {Work-> {[start:7, end: 10], [start:17, end: 22]}, Break->{[start:19, end:20]}}
//
//>
//DayScheduule{
//    List <Intervals> workIntervals;
//    List<Intervals> breakIntervals;
//}
//
//}
//Schedule<Integer, DaySchedule>
//(Entry<Integer,DaySchedule> entry: schedule){
//    List<Interval> workIntervals  = entry.daySchedule.work;
//}
//*/
//
//class ScheduleValidator {
//    public boolean validateSchedule(Map<Integer, DaySchedule> schedule, int maxHour, int maxBreak) {
//        // corner cases
//
//        // Iterate through the schedule
//        boolean result = false;
//
//        // once see an illegal work schedule, return false
//        for (Map.Entry<Integer, DaySchedule> en : schedule) {
//            int lastTime = 0;
//            int sumBreak = 0;
//            for (Interval i : en.getValue()) {
//                if (i.type == work) { // validate work time
//                    if (i.end - i.start >= maxHour ) {
//                        return false;
//                    } else {
//                        if (i.start == lastTime && i.end - lastTime > schedule) {
//                            return false;
//                        } else {
//                            lastTime = i.start == lastTime ? lastTime : i.end;
//                        }
//                    }
//                } else { // validate break
//                    sumBreak += (i.end - i.start);
//                }
//
//                if (sumBreak >= maxBreak) {
//                    return false;
//                }
//
//            }
//        }
//
//        // return true if all
//        return true;
//    }
//}
//
//
//
//
//
///*
//Given an input stream of strings, we want to parse the strings into tri-grams and perform queries on them.
//
//An example of parsing a string: "" -> ["Lorem ipsum dolor", "ipsum dolor sit", "dolor sit amet"]
//
//only have spaces
//all single spaces
//A-Za-z
//
// "Lorem ipsum dolor sit amet"
// 1. trim()
// 2. split() -> how long the String[] >= 3 (good)
//
//Some queries we may want to support:
//1. Did a specific tri-gram appear in the stream?
//2. How many times did a specific tri-gram appear in the stream?
//3. What are the top 10 most frequent tri-grams?
//*/
//
//// interface Iterator<E> {
//// E next();
//// boolean hasNext();}
//
//// iterator.next => "Lorem ipsum dolor sit amet"
//// iterator.next => "Sea purto quando ex"
//
//// hasTrigram("dolor sit amet") -> true
//// hasTrigram("sit amet dolor") -> false
//// ...
//
//class TriGramsAnalyer {
//    Map<String, Integer> counter = new HashMap<>();
//
//    public TriGramsAnalyer(Iterator<String> input) {
//
//        while (input.hasNext()) {
//            updateCounter(input.next());
//        }
//    }
//
//    // O(s.length())
//    private void updateCounter(String s) {
//        // "Lorem ipsum dolor sit amet"
//        String[] strList = s.split("\\s");
//        if (strList.length < 3) return;
//
//        for (int i = 0; i < strList.length - 2; i++) {
//            String curStr = strList[i] + " " + strList[i + 1] + " " + strList[i + 2];
//            counter.put(curStr, counter.getOrDefault(curStr, 0) + 1);
//        }
//
//    }
//
//    // determine if the s is found in input iterator
//    public boolean hasTriGram(String s) {
//        if (s == null) return false;
//        return counter.containsKey(s);
//    }
//
//    // word length m
//    //
//    public List<String> getTenMostFrequent() {
//        List<String> result  = new ArrayList<>();
//
//        // sort
//        Queue<Map.Entry<String, Integer>> maxHeap = new PriorityQueue<>(10, (a, b) -> {return b.getValue() - a.getValue();});
//        for (Map.Entry<String, Integer> en : counter) {
//            maxHeap.offer(en); // lg10
//        }
//
//        while (!maxHeap.isEmpty()) {
//            result.add(maxHeap.poll().getKey());
//        }
//
//        // return
//        return result;
//    }
//
//
//
//    public static void main(String[] args) {
//        TriGramsAnalyer ta = new TriGramsAnalyer(externalIterator);
//        //List<>
//    }
//}