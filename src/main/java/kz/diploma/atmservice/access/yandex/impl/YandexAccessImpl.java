package kz.diploma.atmservice.access.yandex.impl;

import kz.diploma.atmservice.access.yandex.YandexAccess;
import kz.diploma.integration.yandex.api.YandexControllerApiClient;
import kz.diploma.integration.yandex.model.FilterDataResponse;
import kz.diploma.integration.yandex.model.YandexRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class YandexAccessImpl implements YandexAccess {
    private final YandexControllerApiClient yandexControllerApiClient;

    public String getBase64(String text, String speaker){
        var yandexRequest = new YandexRequest();
        yandexRequest.setText(text);
        yandexRequest.setSpeaker(YandexRequest.SpeakerEnum.fromValue(speaker));
        return yandexControllerApiClient.getSpeech(yandexRequest).getBody();
    }

    @Override
    public FilterDataResponse getFilterData() {
        return yandexControllerApiClient.getFilterData().getBody();
    }
}
