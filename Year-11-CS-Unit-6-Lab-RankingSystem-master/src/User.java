import static java.lang.Math.abs;

public class User
{
    private int rank;
    private int progress;

    public User()
    {
        this.progress = 0;
        this.rank =-8;
    }
    public int getRank()
    {
        return rank;
    }

    public int getProgress()
    {
        return progress;
    }

    @Override
    public String toString()
    {
        return "User{" +
                "rank=" + rank +
                ", progress=" + progress +
                '}';
    }

    public void incProgress(int n)
    {
        if(rank==8) {
            return;
        }

        if(n>8 || n<-8 || n==0) {
            throw new IllegalArgumentException("The rank of an activity cannot be less than 8, 0, or greater than 8!");
        }

        if(n==rank) {
            progress =progress+ 3;
        }
        else if(n==rank- 1) {
            progress =progress + 1;
        }
        else if(n<= rank - 2) {

        }
        else {
            int difference;
            if(rank<0 && n>0) {
                difference = abs(n-rank-1);
            }
            else {
                difference = abs(n-rank);
            }
            progress = progress + (10 * difference * difference);
        }

        if(progress >= 100) {
            int c = progress/100;
            if(rank==7) {
                rank++;
                progress=0;
            }
            if(rank == -1) {
                rank +=c+1;
                progress = progress - 100*c;
            }
            else {
                rank+=c;
                progress = progress - 100*c;
            }
        }
    }
}