public class Move {
    //public square current;
    //public square next;

    public int x2;
    public int y2;


    public Move(int x,int y)
    {
        x2=x;
        y2=y;
    }

    @Override
    public boolean equals(Object o)
    {
        if(o instanceof Move)
        {
            if(x2==((Move)o).x2&&y2==((Move)o).y2)
            {
                return true;
            }
        }
        return false;
    }

    public boolean equals(int x, int y)
    {
        if(x2==x&&y2==y)
        {
            return true;
        }
        return false;
    }

}
