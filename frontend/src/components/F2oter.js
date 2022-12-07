import '../App.css';
import { Center } from '@mantine/core';
//import 'bootstrap/dist/css/bootstrap.min.css';


function F2oter(){
    var date = new Date();
    var year = date.getFullYear();
    return (
        <>             

             <Center>
                    <div style ={{'zIndex':'-1','width':'95%','marginTop':'auto', 'position': 'relative', 'bottom': '0px','borderRadius':'15px','background': 'linear-gradient(60.08deg, #0G5AA7 0.53%, #FFFDf4 100%)' }}>
                        <a href = "https://github.com" style = {{'marginRight':'20px'}}>
                            Github
                        </a>

                        <span>
                            © 2022 - {year}    
                        </span>
                    </div>
                </Center>
        </>
    )
}

export default F2oter;