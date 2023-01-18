import {AspectRatio, Center, Image, Text, useMantineTheme} from "@mantine/core";
import '../../assets/fonts/Harlow Solid Regular.ttf'
import logo from '../../assets/logos/LOGO_bookly_resampled_small.png'
import logo_black from '../../assets/logos/LOGO_bookly_resampled_small.png'
import logo_white from '../../assets/logos/LOGO_bookly_resampled_small_white.png'

const BooklyLogo = () => {
    const theme = useMantineTheme();

    return (
        <Center>
            <Image src={theme.colorScheme === 'dark' ? logo_white : logo_black} height={55} alt='Bookly logo'/>
            <Text sx={{
                fontFamily: 'Harlow Solid',
                fontSize: 40,
                lineHeight: 1,
                color: theme.colorScheme === "light" ? 'black' : 'white'
                }}
            >
                Bookly
            </Text>
        </Center>
    );
}

export default BooklyLogo;