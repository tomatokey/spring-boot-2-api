package com.tomatokey.framework.configuration.mvc.converter;

import com.tomatokey.architecture.layer_03_domain.ValueObject;
import lombok.SneakyThrows;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.GenericConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * ValueObjectを継承したクラスを
 * {@link RequestParam}や{@link PathVariable}で使用するためのコンバーター
 */
@Component
public class MvcValueObjectConverter implements GenericConverter {

    @Override
    public Set<ConvertiblePair> getConvertibleTypes() {
        final ConvertiblePair[] pairs = new ConvertiblePair[] {
                new ConvertiblePair(String.class, ValueObject.class),
                new ConvertiblePair(Number.class, ValueObject.class),
        };
        return new HashSet(List.of(pairs));
    }

    @SneakyThrows
    @Override
    public Object convert(Object source, TypeDescriptor sourceType, TypeDescriptor targetType) {
        if (source instanceof String o && targetType.getType().getSuperclass() == ValueObject.class) {
            final Type genericType = ((ParameterizedType) targetType.getType().getGenericSuperclass()).getActualTypeArguments()[0];
            if (genericType == String.class) {
                return targetType.getType().getDeclaredConstructor(String.class).newInstance(o);
            }
            if (genericType == Integer.class) {
                return targetType.getType().getDeclaredConstructor(Integer.class).newInstance(Integer.parseInt(o));
            }
        }

        return source;
    }

}