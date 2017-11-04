public class testF {
    void zero(double i) throws zeroException{
        if(i == 0){
            throw new zeroException();
        }
    }

    void point(double i) throws pointException{
        if(i > 1){
            throw new pointException();
        }
    }
}
