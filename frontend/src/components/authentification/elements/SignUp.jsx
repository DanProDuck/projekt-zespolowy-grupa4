import {
    Paper,
    createStyles,
    TextInput,
    PasswordInput,
    Button,
    Title,
    Text,
    Anchor, Group,
} from '@mantine/core';
import {useForm} from "@mantine/form";
import PasswordWithRequirement from "./additional/PasswordWithRequirement.jsx";

const useStyles = createStyles((theme) => ({
    wrapper: {
        textAlign: 'left',
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

export function SignUp() {
    const {classes} = useStyles();

    const form = useForm(
        {
            initialValues: {
                name: '',
                surname: '',
                username: '',
                email: '',
                password: '',
                repeatedPassword: ''
            }
        }
    )

    const submitHandler = () => {

        fetch('https://api-bookly.herokuapp.com/auth/registration', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
                'Access-Control-Allow-Origin': '*'
            },
            body:
                JSON.stringify({...form.values, repeatedPassword: form.values.password}) 
        }). then(r => console.log(r.body))
    }

    return (
        <div className={classes.wrapper}>
            <Paper className={classes.form} radius={0} p={30}>
                <Title order={2} className={classes.title} align="center" mt="md" mb={50}>
                    Create an account here at Bookly!
                </Title>

                <Group grow>
                    <TextInput autoFocus label="First name" placeholder="John"
                               size="md" {...form.getInputProps('name')} />
                    <TextInput label="Last name" placeholder="Smith"
                               size="md" {...form.getInputProps('surname')} />
                </Group>
                <TextInput label="Username" placeholder="john_smith" mt="md"
                           size="md" {...form.getInputProps('username')} />
                <TextInput label="Email address" placeholder="hello@gmail.com" mt="md"
                           size="md" {...form.getInputProps('email')} />
                <PasswordWithRequirement/>
                <PasswordInput label="Repeat password" placeholder="Repeat your password" mt="md"
                               size="md" {...form.getInputProps('password')} />
                
                <Button fullWidth type="submit" mt="xl" size="md" onClick={submitHandler}>
                    Register
                </Button>

                <Text align="center" mt="md">
                    Already have an account?{' '}
                    <Anchor href="/login" weight={700}>
                        Log In
                    </Anchor>
                </Text>
            </Paper>
        </div>
    );
}