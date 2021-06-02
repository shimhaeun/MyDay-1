package org.ict.myday.retrofit_test;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

//Retrofit2는 인터페이스와 클라이언트로 구성됩니다.
// 인터페이스에는 호출방식, 호출할 베이스 주소, 붙일 파라미터를 정의할 수 있습니다.
public interface RetrofitInterface {

    // 아래의 @GET 말고도, @POST, @PATCH, @PUT, @DELETE를 사용할 수 있으며 타겟주소를 파라미터로 넣어줍니다.
    @GET("http://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json")
    // 요청 결과는 Call<자료형>이 마치 ResponseEntity<자료형>처럼 작동합니다.
    // 요청 주소에 붙일 파라미터는 내부 어노테이션 @Query("파라미터명") 자료형 값 순서로 정의할 수 있습니다.
    Call<Example> getBoxOffice(@Query("key") String key, @Query("targetDt") String targetDt);
}
