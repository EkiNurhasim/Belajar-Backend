package ekiasari.webmvc.converter;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class StringToDateConverter implements Converter<String, Date> {

    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyy-MM-dd");

    @Override
    public Date convert(@SuppressWarnings("null") String source) {
        try {
            return dateFormat.parse(source);
        } catch (Exception e) {
            log.info("Error convert date to string {} ", source, e.getMessage());
            return null;
        }
    }

}
