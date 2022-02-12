# TodayCardWithMVVM
#### AAC 학습 후 “오늘의 카드” 앱을 어떻게 개선할지 고민했고, 기존 앱의 일부를 개선했습니다.
###### (AAC 학습 내용은 https://junnn183.tistory.com/ 에 간략히 정리해 두었습니다.)
#### “오늘의 카드” 앱의 ‘직접 입력’ 기능을 AAC로 MVVM 패턴에 맞게 구조적 개선을 했습니다.
#      
### 1.화면 변경
#### [기존의 ‘직접 입력’ 기능]
<img src = "https://user-images.githubusercontent.com/87768226/130711758-7525d693-a349-4e0d-95b4-a3c64fe5f37c.PNG" width="55%" height="55%">

#### [변경된 ‘직접 입력’ 기능]
<img src = "https://user-images.githubusercontent.com/87768226/130712285-22b2a04d-3f17-4076-8913-90c1ea8ff47e.PNG" width="80%" height="80%">

#      
### 2.구조 개선
<img src = "https://user-images.githubusercontent.com/87768226/130712301-36711f45-963b-450d-b63c-2999750a67cc.PNG" width="70%" height="70%">

#   
### 3.코드 개선
### 3-1) Data Binding
#### [기존 코드]
<img src = "https://user-images.githubusercontent.com/87768226/130712328-f86dbbdc-9c0e-4bd5-b90f-940992039a4c.PNG" width="40%" height="40%">

#### [개선 코드]
<img src = "https://user-images.githubusercontent.com/87768226/130712357-1b935bac-ee70-4f46-8382-56d7ed318f0f.PNG" width="50%" height="50%">

##### Data Binding을 사용해 따로 View 레퍼런스나 findViewById()를 하지 않고 View 객체를 획득해 사용했습니다.
### 3-2) LiveData와 Observe
#### [기존 코드]
#### MainActivity
<img src = "https://user-images.githubusercontent.com/87768226/130712389-4e3c3c18-25af-411b-987f-cb0c36df88a5.PNG" width="45%" height="45%">

<img src = "https://user-images.githubusercontent.com/87768226/130712410-ca4ba0b7-9bde-4513-979d-41de27a57208.PNG" width="80%" height="80%">

##### MainActivity에서 Database에 직접 접근해 EditText 값을 Insert합니다.
#### [개선 코드]
#### CardUsageViewModel
<img src = "https://user-images.githubusercontent.com/87768226/130712457-7850ce21-3f82-48e6-aad1-2f5ff62ffaef.PNG" width="50%" height="50%">

#### MainActivity
<img src = "https://user-images.githubusercontent.com/87768226/130712486-a3772b37-6eeb-44ff-9380-9a1c8802005c.PNG" width="65%" height="65%">

<img src = "https://user-images.githubusercontent.com/87768226/130712515-251216f2-d766-406f-9f17-1118a4cf0e47.PNG" width="70%" height="70%">

##### MainActivity에서 Database에 직접 접근하지 않고 ViewModel에게 데이터를 전달합니다. 또한 LiveData와 Observe를 통해 데이터가 변경되면 자동으로 업데이트 코드를 실행합니다.
### 3-3) Room
#### [기존 코드]
<img src = "https://user-images.githubusercontent.com/87768226/130712537-6ceba942-babd-4bf1-89fd-deebdb43c4b6.PNG" width="50%" height="50%">

#### [개선 코드]
###### Entity
<img src = "https://user-images.githubusercontent.com/87768226/130712547-f40425ec-d725-49d7-8535-868178352c1f.PNG" width="30%" height="30%">

###### DAO
<img src = "https://user-images.githubusercontent.com/87768226/130712575-151d13ca-c013-4315-bba9-10a55b1a59ff.PNG" width="30%" height="30%">

###### Database
<img src = "https://user-images.githubusercontent.com/87768226/130712590-285aa5e3-e5d2-4fe9-9410-b7a124dea62f.PNG" width="50%" height="50%">

##### SQLiteDatabase를 직접 생성하지 않고 Room을 이용해 SQLiteDatabase를 사용합니다.
