import {HeroComponent} from "../hero/HeroComponent.jsx";

const Hero = (props) => {
    return (
        <HeroComponent scrollHandler={props.scrollFunc}/>
    );
}

export default Hero;