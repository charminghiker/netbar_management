export default class AjaxUtils {
    constructor() {}
    get(url, callback) {
        let xhr = new XMLHttpRequest();
        xhr.open("get", url, true);
        xhr.responseType = "json";
        xhr.addEventListener("readystatechange", () => {
            if (xhr.readyState == 4 && xhr.status == 200) {
                callback(xhr);
            }
        }, false);
        xhr.send(null);
    }
}