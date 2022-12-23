package exception;

public class ExceptionEx6 {
    public static void main(String[] args) {
        System.out.println("R1");
        try(CloseableResource cr = new CloseableResource()) {
            cr.exceptionWork(false);
        } catch (WorkException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } catch (CloseException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }


        System.out.println("R2");
        try(CloseableResource cr = new CloseableResource()) {
            cr.exceptionWork(true);
        } catch (WorkException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } catch (CloseException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}

class CloseableResource implements AutoCloseable {
    public void exceptionWork(boolean exception) throws WorkException {
        System.out.println("exceptionWork(" + exception + ")");
        if (exception) {
            throw new WorkException("WorkException!!");
        }
    }

    @Override
    public void close() throws CloseException {
        System.out.println("close()");
        throw new CloseException("CloseException!!");
    }
}

class WorkException extends Exception {
    WorkException(String msg) {
        super(msg);
    }
}

class CloseException extends Exception {
    CloseException(String msg) {
        super(msg);
    }
}