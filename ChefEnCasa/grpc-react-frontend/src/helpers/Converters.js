export const convertBase64 = async (file) => {
      return new Promise((resolve, reject) => {
        convert(file, resolve, reject);
      });
  };

const convert = (file, resolve, reject) => {
    let arrayAuxiliar = [];
    let reader = new FileReader();
    reader.readAsDataURL(file);
    reader.onload = function () {
        let base_64 = reader.result;
        arrayAuxiliar = base_64.split(",");
        resolve(arrayAuxiliar[1]);
    };
    reader.onerror = (error) => {
        reject(error);
    };
};