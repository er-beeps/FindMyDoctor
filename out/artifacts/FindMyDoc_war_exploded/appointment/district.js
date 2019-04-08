
var districts = new  Array();
districts['Province 1']=new Array('Bhojpur','Dhankuta','Ilam','Jhapa','Khotang','Morang','Okhaldhunga','Panchthar','Sankhuwasabha','Solukhumbu','Sunsari','Taplejung','Terhathum','Udayapur');
districts['Province 2']=new Array('Bara','Dhanusha','Mahottari','Parsa','Rautahat','Saptari','Sarlahi','Siraha');
districts['Province 3']=new Array('Bhaktapur','Chitwan','Dhading','Dolakha','Kathmandu','Kavrepalanchok','Lalitpur','Makwanpur','Nuwakot','Ramechhap','Rasuwa','Sindhuli','Sindhupalchok');
districts['Province 4']=new Array('Baglung','Gorkha','Kaski','Lamjung','Manang','Mustang','Myagdi','Nawalpur','Parbat','Syangja','Tanahun');
districts['Province 5']=new Array('Arghakhanchi','Banke','Bradiya','Dang','Eastern Rukum','Gulmi','Kapilvastu','Parasi','Palpa','Pyuthan','Rolpa','Rupandehi');
districts['Province 6']=new Array('Dailekh','Dolpa','Humla','Jajarkot','Jumla','Kalikot','Mugu','Salyan','Surkhet','Western Rukum');
districts['Province 7']=new Array('Achham','Baitadi','Bajhang','Bajura','Dadeldhura','Darchula','Doti','Kailali','Kanchanpur');


function setDistricts() {
    provinceSel=document.getElementById('province');
    districtList=districts[provinceSel.value];
    changeSelect('district',districtList,districtList);
}

function changeSelect(fieldID,newOptions,newValues) {
    selectField=document.getElementById(fieldID);
    selectField.options.length=0;
    for (i=0; i<newOptions.length; i++){
        selectField.options[selectField.length]=new Option(newOptions[i],newValues[i]);
    }

}
function addLoadEvent(func) {
    var oldonload=window.onload;
    if(typeof window.onload !='function'){
        window.onload=func;
    }else{
        window.onload=function (){
            if(oldonload){
                oldonload();
            }
            func();
        }
    }

}
addLoadEvent(function () {
    setDistricts();
});
