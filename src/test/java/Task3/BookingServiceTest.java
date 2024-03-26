package Task3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.time.LocalDateTime;
import java.time.Month;

import static org.mockito.Mockito.*;

public class BookingServiceTest {
    @Mock
    private BookingService bookingService;
    private LocalDateTime from;
    private LocalDateTime to;

    private static final Logger logger
            = LoggerFactory.getLogger(BookingServiceTest.class);

    @BeforeEach
    void init() {
        bookingService = mock(BookingService.class);
        from = LocalDateTime.of(2024, Month.FEBRUARY, 19, 8, 0, 0);
        to = LocalDateTime.of(2024, Month.FEBRUARY, 23, 16, 0, 0);
    }

    @Test
    void bookingWhenFreeTimeInDBTest() throws CantBookException {
        logger.info("Запущен тест проверки со свободным слотом времени от {} до {} для записи в СУБД ", from, to);
        //given
        logger.debug("Формирование мока для метода book()");
        when(bookingService.book("1527", from, to)).thenReturn(true);
        //when
        boolean result = bookingService.book("1527", from, to);
        //then
        Assertions.assertTrue(result);
        logger.info("Проверка что произошел вызов метода с замокированными параметрами");
        verify(bookingService).book("1527", from, to);
        logger.info("Проверка завершена");


    }

    @Test
    void bookingWhenNotFreeTimeInDBTest() throws CantBookException {
        logger.info("Запущен тест проверки со занятым слотом времени от {} до {} для записи в СУБД ", from, to);

        //given
        logger.debug("Формирование мока для метода book()");
        Mockito.doThrow(CantBookException.class).when(bookingService).book("1799", from, to);
        //then
        Assertions.assertThrows(CantBookException.class, () -> {
            bookingService.book("1799", from, to);
        }, "Время занято");
        logger.info("Проверка что произошел вызов метода с замокированными параметрами");
        verify(bookingService).book("1799", from, to);
        logger.info("Проверка завершена");

    }

}
