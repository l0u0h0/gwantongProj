<template>
  <div>
    <div class="border-radius-lg shadow-dark" id="map"></div>
  </div>
</template>

<script>
export default {
  name: "TripMap",
  components: {},
  data() {
    return {
      map: null,
      positions: [],
      markers: [],
    };
  },
  props: {
    places: [],
  },
  watch: {
    places() {
      console.log(this.places)
      this.positions = [];
      this.places.forEach((place) => {
        let obj = {};
        obj.title = place.title;
        obj.latlng = new kakao.maps.LatLng(place.latitude, place.longitude);
        obj.img = place.first_image;
        obj.addr1 = place.addr1;
        obj.addr2 = place.addr2;
        obj.tel = place.tel;

        this.positions.push(obj);
      });
      console.log(this.positions);
      // this.loadMaker();
      this.displayMarker();
    },
  },
  created() { },
  mounted() {
    if (window.kakao && window.kakao.maps) {
      this.loadMap();
    } else {
      this.loadScript();
    }
  },
  methods: {
    displayMarker() {
      this.positions.forEach(function (pos) {

        const marker = new window.kakao.maps.Marker({
          map: this.map,
          position: pos.latlng,
          title: pos.title,
        });
        // content HTMLElement 생성
        var wrap = document.createElement("div");
        wrap.className = "wrap";
        // 정보 그릴 영역 wrap > info
        var info = document.createElement("div");
        info.className = "info";
        // 제목과 닫기 버튼 들어갈 영역 info > title
        var title = document.createElement("div");
        title.className = "title";
        title.appendChild(document.createTextNode(pos.title));
        // close btn add title > close
        var closeBtn = document.createElement("div");
        closeBtn.className = "close";
        closeBtn.setAttribute("title", "닫기");
        // 닫기 이벤트 추가
        closeBtn.onclick = function () {
          overlay.setMap(null);
        };
        title.appendChild(closeBtn);

        info.appendChild(title);

        // 이미지와 설명 담을 영역 info > body
        var body = document.createElement("div");
        body.className = "body";
        // 이미지 태그 body > img
        var img = document.createElement("img");
        img.className = "img";
        // 데이터 있으면 넣기
        img.setAttribute("src", pos.img.length > 1 ? pos.img : "#");
        body.appendChild(img);
        // 설명 영역 body > desc
        var desc = document.createElement("div");
        desc.className = "desc";
        // 도로명 주소 desc > ellipsis
        var addr1 = document.createElement("div");
        addr1.className = "ellipsis";
        addr1.appendChild(document.createTextNode(pos.addr1));
        // 지번 주소 desc > jibun ellipsis
        var addr2 = document.createElement("div");
        addr2.className = "jibun ellipsis";
        addr2.appendChild(document.createTextNode(pos.addr2));
        // 관광지 전화번호 desc > tel
        var tel = document.createElement("div");
        tel.className = "tel";
        tel.appendChild(document.createTextNode(pos.tel));

        desc.appendChild(addr1);
        desc.appendChild(addr2);
        desc.appendChild(tel);

        body.appendChild(desc);

        info.appendChild(body);

        // 태그들 취합
        wrap.appendChild(info);

        // customoverlay 생성, 이때 map을 선언하지 않으면 지도위에 올라가지 않습니다.
        var overlay = new daum.maps.CustomOverlay({
          position: pos.latlng,
          content: wrap,
        });

        // 마커를 클릭했을 때 커스텀 오버레이를 표시합니다
        window.kakao.maps.event.addListener(marker, "click", function () {
          overlay.setMap(this.map);
        });
      });

      // 첫번째 검색 정보를 이용하여 지도 중심을 이동 시킵니다
      this.map.setCenter(this.positions[0].latlng);
    }
    ,
    loadScript() {
      const script = document.createElement("script");
      script.src =
        "//dapi.kakao.com/v2/maps/sdk.js?appkey=" +
        process.env.VUE_APP_KAKAO_KEY +
        "&autoload=false&libraries=services,clusterer,drawing";
      /* global kakao */
      script.onload = () => window.kakao.maps.load(this.loadMap);

      document.head.appendChild(script);
    },
    loadMap() {
      const container = document.getElementById("map");
      const options = {
        center: new window.kakao.maps.LatLng(33.450701, 126.570667),
        level: 3,
      };

      this.map = new window.kakao.maps.Map(container, options);
      //   this.loadMaker();
    },
    loadMaker() {
      this.deleteMarker();
      
      this.markers = [];
      this.positions.forEach((position) => {
        const marker = new window.kakao.maps.Marker({
          map: this.map,
          position: position.latlng,
          title: position.title,
        });
        this.markers.push(marker);
      });
      console.log("마커수 ::: " + this.markers.length);

      this.map.setCenter(this.positions[0].latlng);
    },
    deleteMarker() {
      if (this.markers.length > 0) {
        this.markers.forEach((item) => {
          item.setMap(null);
        });
      }
    },
  },
};
</script>

<style scoped>
#map {
  width: 95%;
  height: 60vh;
}
</style>
