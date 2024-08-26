const menuBtn = document.getElementById('menu-btn')
const menu = document.querySelector('menu')


menuBtn.addEventListener('click',onMenuClick);
 
function onMenuClick() {
    menu.classList.toggle('d-none');
}