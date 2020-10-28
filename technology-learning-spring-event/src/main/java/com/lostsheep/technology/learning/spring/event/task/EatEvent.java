package com.lostsheep.technology.learning.spring.event.task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEvent;

/**
 * <b><code>EatEvent</code></b>
 * <p/>
 * 吃饭事件
 * <p/>
 * <b>Creation Time:</b> 2020/10/28 10:57.
 *
 * @author dengzhen
 * @since technology-learning-multiple-thread 1.0.0
 */
@Slf4j
public class EatEvent extends ApplicationEvent {

    private final boolean eatFinished;

    /**
     * 继承{@link ApplicationEvent}调用其{@link ApplicationEvent#ApplicationEvent(Object)}
     * 构造方法, 可传递{@link Object}类型资源信号
     *
     * @param eatFinished 是否已经完成吃饭的信号的 boolean 值
     */
    public EatEvent(boolean eatFinished) {
        super(eatFinished);
        this.eatFinished = eatFinished;
    }

    /**
     * 此方法会由监听器{@link com.lostsheep.technology.learning.spring.event.listener.EatEventListener}执行
     */
    public void callParent() {
        log.info("妈, 我吃完饭了, 你收拾吧!");
    }

    /**
     * 同上
     */
    public void callFriend() {
        log.info("老铁, 吃完饭了, 开黑搞起!");
    }

    /**
     * @return 吃完饭的信号
     */
    public boolean isEatFinished() {
        return this.eatFinished;
    }

}
