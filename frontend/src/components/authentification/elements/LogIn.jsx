import {
    Paper,
    createStyles,
    TextInput,
    PasswordInput,
    Checkbox,
    Button,
    Title,
    Text,
    Anchor, Modal, useMantineTheme,
} from '@mantine/core';
import {ResetPassword} from "./ResetPassword.jsx";
import {useState} from "react";
import {useForm} from "@mantine/form";

const useStyles = createStyles((theme) => ({
    wrapper: {
        minHeight: 900,
        backgroundSize: 'cover',
        backgroundImage:
            'url(https://images.unsplash.com/photo-1484242857719-4b9144542727?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=1280&q=80)',
    },

    form: {
        border: `1px solid ${
            theme.colorScheme === 'dark' ? theme.colors.dark[7] : theme.colors.gray[3]
        }`,
        minHeight: 900,
        maxWidth: 450,
        paddingTop: 80,

        [`@media (max-width: ${theme.breakpoints.sm}px)`]: {
            maxWidth: '100%',
        },
    },

    title: {
        color: theme.colorScheme === 'dark' ? theme.white : theme.black,
        fontFamily: `Greycliff CF, ${theme.fontFamily}`,
    },

    logo: {
        color: theme.colorScheme === 'dark' ? theme.white : theme.black,
        width: 120,
        display: 'block',
        marginLeft: 'auto',
        marginRight: 'auto',
    },
}));

export function LogIn() {
    const [opened, setOpened] = useState(false);

    const {classes} = useStyles();
    const theme = useMantineTheme();

    function handleLogin(){
        fetch('https://api-bookly.herokuapp.com/auth/login', {
            method: 'POST',
            credentials: 'include',
            headers: {
                'Content-Type': 'application/json',
                'Access-Control-Allow-Origin': '*'
            },
            body:
                JSON.stringify({...form.values})
        }). then(r => console.log(r.body))
    }

    let form = useForm(
        {
            username: '',
            password: ''
        }
    )

    return (
        <>
            <Modal
                withCloseButton={false}
                opened={opened}
                centered
                onClose={() => setOpened(false)}
                overlayColor={theme.colorScheme === 'dark' ? theme.colors.dark[9] : theme.colors.gray[2]}
                overlayOpacity={0.55}
                overlayBlur={3}
                exitTransitionDuration={300}
                transitionTimingFunction="ease"
            >
                <ResetPassword onReturnToLogin={setOpened}/>
            </Modal>

            <div className={classes.wrapper}>
                <Paper className={classes.form} radius={0} p={30}>
                    <Title order={2} className={classes.title} align="center" mt="md" mb={50}>
                        Welcome back to Bookly!
                    </Title>

                    <TextInput autoFocus label="Email address or login" placeholder="hello@gmail.com" size="md" {...form.getInputProps('username')}/>
                    <PasswordInput label="Password" placeholder="Your password" mt="md" size="md" {...form.getInputProps('password')}/>
                    <Checkbox label="Keep me logged in" mt="xl" size="md"/>
                    <Button fullWidth mt="xl" size="md" onClick={handleLogin}>
                        Login
                    </Button>

                    <Text align="center" mt="md">
                        Don&apos;t have an account?{' '}
                        <Anchor href="/signup" weight={700}>
                            Register
                        </Anchor>
                    </Text>
                    <Text align="center" mt="xs">
                        <Anchor component={'button'} onClick={() => setOpened(true)} weight={600} underline={false}>
                            Forgot password?
                        </Anchor>
                    </Text>
                </Paper>
            </div>
        </>
    );
}