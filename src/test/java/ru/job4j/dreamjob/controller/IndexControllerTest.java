package ru.job4j.dreamjob.controller;

import org.junit.jupiter.api.Test;
import org.springframework.ui.Model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class IndexControllerTest {

    @Test
    void testGetIndex() {
        Model model = mock(Model.class);
        IndexController indexController = new IndexController();
        String viewName = indexController.getIndex();
        assertThat(viewName).isEqualTo("index");
    }
}