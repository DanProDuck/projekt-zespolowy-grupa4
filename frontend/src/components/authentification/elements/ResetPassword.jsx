import {
    createStyles,
    Paper,
    Title,
    Text,
    TextInput,
    Button,
    Container,
    Group,
    Anchor,
    Center,
    Box,
} from '@mantine/core';
import { IconArrowLeft } from '@tabler/icons';

const useStyles = createStyles((theme) => ({
    title: {
        fontSize: 26,
        fontWeight: 900,
        fontFamily: `Greycliff CF, ${theme.fontFamily}`,
    },

    controls: {
        [theme.fn.smallerThan('xs')]: {
            flexDirection: 'column-reverse',
        },
    },

    control: {
        [theme.fn.smallerThan('xs')]: {
            width: '100%',
            textAlign: 'center',
        },
    },
}));

export function ResetPassword(props) {
    const { classes } = useStyles();

    let backToLoginButton =
        <Anchor href="/login" color="dimmed" size="sm" className={classes.control}>
            <Center inline>
                <IconArrowLeft size={12} stroke={1.5} />
                <Box ml={5}>Back to login page</Box>
            </Center>
        </Anchor>

    if(props.onReturnToLogin){
        backToLoginButton = <Anchor component={'button'} onClick={props.onReturnToLogin} color="dimmed" size="sm" className={classes.control}>
            <Center inline>
                <IconArrowLeft size={12} stroke={1.5} />
                <Box ml={5}>Back to login page</Box>
            </Center>
        </Anchor>
    }

    return (
        <Container size={460} my={30}>
            <Title className={classes.title} align="center">
                Forgot your password?
            </Title>
            <Text color="dimmed" size="sm" align="center">
                Enter your email to get a reset link
            </Text>

            <Paper withBorder shadow="md" p={30} radius="md" mt="xl">
                <TextInput label="Your email" placeholder="hello@gmail.com" data-autofocus required />
                <Group position="apart" mt="lg" className={classes.controls}>
                    {backToLoginButton}
                    <Button className={classes.control}>Reset password</Button>
                </Group>
            </Paper>
        </Container>
    );
}