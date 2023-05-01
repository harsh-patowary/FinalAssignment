package ExerciseFour;

public class PriceDate implements Comparable<PriceDate> {
    private int Day, Year;
    private String Month;
    PriceDate(int d, String m, int y){
        this.Day = d;
        this.Month = m;
        this.Year = y;
    }

    public int getDay() {
        return Day;
    }

    public String getMonth() {
        return Month;
    }

    public int getYear() {
        return Year;
    }

    private static int getMonthValue(String month) {
        switch (month) {
            case "Jan":
                return 1;
            case "Feb":
                return 2;
            case "Mar":
                return 3;
            case "Apr":
                return 4;
            case "May":
                return 5;
            case "Jun":
                return 6;
            case "Jul":
                return 7;
            case "Aug":
                return 8;
            case "Sep":
                return 9;
            case "Oct":
                return 10;
            case "Nov":
                return 11;
            case "Dec":
                return 12;
            default:
                throw new IllegalArgumentException("Invalid month string: " + month);
        }
    }


    @Override
    public int compareTo(PriceDate other) {
        if (this.Year != other.Year)
            return this.Year - other.Year;
        else {
//            System.out.println(this.Month+ " " + other.Month);
            int thisMonth = getMonthValue(this.Month);
            int otherMonth = getMonthValue(other.Month);
            if (thisMonth != otherMonth) return thisMonth-otherMonth;
            else return this.Day-other.Day;
        }
    }

    @Override
    public String toString(){
        return this.Day+"-"+this.Month+"-"+this.Year;
    }
}
