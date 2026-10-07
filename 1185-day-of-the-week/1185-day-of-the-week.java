import java.time.LocalDate;

class Solution {
    public String dayOfTheWeek(int day, int month, int year) {
        LocalDate date = LocalDate.of(year, month, day);
        
        // Capitalize only the first letter (e.g., "SATURDAY" -> "Saturday")
        String dayName = date.getDayOfWeek().name();
        return dayName.substring(0, 1) + dayName.substring(1).toLowerCase();
    }
}