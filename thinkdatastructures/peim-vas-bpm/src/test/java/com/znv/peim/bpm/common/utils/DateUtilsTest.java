package com.znv.peim.bpm.common.utils;

import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static com.znv.peim.bpm.common.utils.DateUtils.*;
import static java.util.stream.Collectors.toList;
import static org.apache.commons.lang3.time.DateUtils.*;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Yum
 * @version 1.0
 * @since 2020-10-13 09:35:42
 */
class DateUtilsTest {

    @Test
    void should_generate_continuous_year_months() {
        // given
        String m3 = "202007";
        String m2 = "202008";
        String m1 = "202009";
        String m0 = "202010";
        String m_1 = "202011";
        String m_2 = "202012";
        String m_3 = "202101";
        String m_4 = "202102";
        // when
        Stream<String> monthStream = rangeDates(3,
                4,
                YEAR_MONTH_PATTERN,
                org.apache.commons.lang3.time.DateUtils::addMonths);
        // then
        assertThat(monthStream.collect(toList())).containsExactlyInAnyOrder(m3, m2, m1, m0, m_1, m_2, m_3, m_4);
    }

    @Test
    void should_generate_continuous_years() {
        // given
        Date date = new Date();
        String y1 = format(addYears(date, -1), YEAR_PATTERN);
        String y2 = format(date, YEAR_PATTERN);
        String y3 = format(addYears(date, 1), YEAR_PATTERN);
        // when
        Stream<String> yearStream = rangeDates(1,
                1,
                YEAR_PATTERN,
                org.apache.commons.lang3.time.DateUtils::addYears);
        // then
        assertThat(yearStream.collect(toList())).containsExactlyInAnyOrder(y1, y2, y3);
    }

    @Test
    void should_generate_range_days() {
        // given
        Date date = new Date();
        String day1 = format(new Date(), YEAR_MONTH_DAY_PATTERN);
        String day2 = format(addDays(date, 1), YEAR_MONTH_DAY_PATTERN);
        // when
        Stream<String> dayStream = rangeDates(0,
                1,
                YEAR_MONTH_DAY_PATTERN,
                org.apache.commons.lang3.time.DateUtils::addDays);
        // then
        assertThat(dayStream.collect(toList())).containsExactlyInAnyOrder(day1, day2);
    }

    @Test
    void should_generate_range_months_with_start_and_end_date() {
        // when
        Stream<String> months = DateUtils.rangeDates("2020-08-20", "2020-11-12", YEAR_MONTH_PATTERN);
        Stream<String> months2 = DateUtils.rangeDates("2020-07-01", "2020-09-12", YEAR_MONTH_PATTERN);
        // then
        assertThat(months.collect(toList())).containsExactlyInAnyOrder("202008", "202009", "202010", "202011");
        assertThat(months2.collect(toList())).containsExactlyInAnyOrder("202007", "202008", "202009");
    }

    @Test
    void should_generate_range_years_with_start_and_end_date() {
        // when
        Stream<String> months = DateUtils.rangeDates("2017-08-20", "2020-11-12", YEAR_PATTERN);
        Stream<String> months2 = DateUtils.rangeDates("2020-07-01", "2020-09-12", YEAR_PATTERN);
        // then
        assertThat(months.collect(toList())).containsExactlyInAnyOrder("2017", "2018", "2019", "2020");
        assertThat(months2.collect(toList())).containsExactlyInAnyOrder("2020");
    }

    @Test
    void should_calculate_diff_days_between_start_and_end_date() throws ParseException {
        long days = diff("2020-10-18", "2020-10-20", TimeUnit.DAYS, "yyyy-MM-dd");
        long daysAfter = diff("2020-10-22", "2020-10-20", TimeUnit.DAYS, "yyyy-MM-dd");
        assertThat(days).isEqualTo(2);
        assertThat(daysAfter).isEqualTo(-2);
    }

    @Test
    void should_half_hour_list_return_correctly() {
        // when
        List<String> list = halfHourList("20201018");
        // then
        assertThat(list).containsExactly(
                "2020-10-18 00:00:00","2020-10-18 00:30:00",
                "2020-10-18 01:00:00","2020-10-18 01:30:00",
                "2020-10-18 02:00:00","2020-10-18 02:30:00",
                "2020-10-18 03:00:00","2020-10-18 03:30:00",
                "2020-10-18 04:00:00","2020-10-18 04:30:00",
                "2020-10-18 05:00:00","2020-10-18 05:30:00",
                "2020-10-18 06:00:00","2020-10-18 06:30:00",
                "2020-10-18 07:00:00","2020-10-18 07:30:00",
                "2020-10-18 08:00:00","2020-10-18 08:30:00",
                "2020-10-18 09:00:00","2020-10-18 09:30:00",
                "2020-10-18 10:00:00","2020-10-18 10:30:00",
                "2020-10-18 11:00:00","2020-10-18 11:30:00",
                "2020-10-18 12:00:00","2020-10-18 12:30:00",
                "2020-10-18 13:00:00","2020-10-18 13:30:00",
                "2020-10-18 14:00:00","2020-10-18 14:30:00",
                "2020-10-18 15:00:00","2020-10-18 15:30:00",
                "2020-10-18 16:00:00","2020-10-18 16:30:00",
                "2020-10-18 17:00:00","2020-10-18 17:30:00",
                "2020-10-18 18:00:00","2020-10-18 18:30:00",
                "2020-10-18 19:00:00","2020-10-18 19:30:00",
                "2020-10-18 20:00:00","2020-10-18 20:30:00",
                "2020-10-18 21:00:00","2020-10-18 21:30:00",
                "2020-10-18 22:00:00","2020-10-18 22:30:00",
                "2020-10-18 23:00:00","2020-10-18 23:30:00"
        );
    }

    @Test
    void should_obtain_date_pattern_string() {
        // when
        String date = datePattern("2020-10-18 00:90:00");
        String date2 = datePattern("2020-10-18");
        String date3 = datePattern("2020-10-1");
        // then
        assertThat(date).isEqualTo("2020-10-18");
        assertThat(date2).isEqualTo("2020-10-18");
        assertThat(date3).isEqualTo("2020-10-1");
    }

}