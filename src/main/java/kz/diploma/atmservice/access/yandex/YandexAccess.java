package kz.diploma.atmservice.access.yandex;

import kz.diploma.integration.yandex.model.FilterDataResponse;
import kz.diploma.integration.yandex.model.YandexRequest;

public interface YandexAccess {

    public String getBase64(String text, String speaker);

    public FilterDataResponse getFilterData();

}