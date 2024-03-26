package Task3;

import java.time.LocalDateTime;

public class BookingService {

    //запись
    public boolean book(String userId, LocalDateTime from, LocalDateTime to) throws CantBookException {
        if(checkTimeInBD(from, to)) {
            return createBook(userId,from, to);
        }
        throw new CantBookException();
    }
    //метод занятости слота времени в СУБД
    public boolean checkTimeInBD(LocalDateTime from, LocalDateTime to) {
        return false;
    }
    // метод бронирования
    public boolean createBook(String userId, LocalDateTime from, LocalDateTime to) {
        return false;
    }
}
