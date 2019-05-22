package com.woowacourse.laddergame.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;


class PlayersTest {
    @Test
    void player_인덱스_반환() {
        Players players = new Players(Arrays.asList(
                new Player("pobi"),
                new Player("aiden"),
                new Player("jay"))
        );
        assertThat(players.getPlayerNo("aiden")).isEqualTo(2);
    }

    @Test
    void 이름이_중복되는_경우() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            Players players = new Players(Arrays.asList(
                    new Player("pobi"),
                    new Player("pobi"))
            );
        }).withMessage("이름은 중복될 수 없습니다");
    }
}