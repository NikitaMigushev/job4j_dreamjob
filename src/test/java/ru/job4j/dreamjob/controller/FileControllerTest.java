package ru.job4j.dreamjob.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import ru.job4j.dreamjob.dto.FileDto;
import ru.job4j.dreamjob.service.FileService;

import java.io.IOException;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class FileControllerTest {
    @Mock
    private FileService fileService;

    @InjectMocks
    private FileController fileController;

    @BeforeEach
    public void initService() {
        fileService = mock(FileService.class);
        fileController = new FileController(fileService);
    }

    @Test
    public void testGetById() throws IOException {
        int fileId = 1;
        String fileName = "test-file.txt";
        String fileContent = "Test file content";
        when(fileService.getFileById(fileId)).thenReturn(Optional.of(new FileDto(fileName, fileContent.getBytes())));
        ResponseEntity<?> response = fileController.getById(fileId);
        verify(fileService, times(1)).getFileById(fileId);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(new String((byte[]) response.getBody())).isEqualTo(fileContent);
    }

    @Test
    public void testGetByIdNotFound() {
        int fileId = 1;
        when(fileService.getFileById(fileId)).thenReturn(Optional.empty());
        ResponseEntity<?> response = fileController.getById(fileId);
        verify(fileService, times(1)).getFileById(fileId);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
        assertThat(response.getBody()).isNull();
    }
}