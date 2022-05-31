package com.prototype.architecture.layer_03_domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.prototype.architecture.layer_03_domain.user.UserId;
import com.prototype.framework.utils.ObjectUtils;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.validation.constraints.NotNull;

/**
 * 値が1つだけのバリューオブジェクト用基底クラス
 *
 * @param <T> value
 */
@EqualsAndHashCode
@ToString
public abstract class SingleValueObject<T extends Comparable<T>> {

    /**
     * 子クラスで指定した型の値
     *
     * {@link JsonValue}を付与することによって、例えば
     * {@code {"user_id": {value: 1}}}だったものが
     * {@code {"user_id": 1}}のようにシリアライズされます
     */
    @JsonValue
    protected final T value;

    @JsonCreator
    protected SingleValueObject(T value) {
        this.value = value;
    }

    /**
     * 値を取得します
     *
     * {@link NotNull}バリデーションを変更したい場合は、
     * このメソッドを@Overrideして異なるバリデーション用アノテーションを付与してください
     *
     * @return
     */
    @NotNull
    public T getValue() {
        return value;
    }

    /**
     * 値が不正かどうか判定します
     *
     * より詳細な判定が必要な場合は@Overrideして変更してください
     *
     * @return
     */
    public boolean isInvalid() {
        return ObjectUtils.isEmpty(value);
    }

}
