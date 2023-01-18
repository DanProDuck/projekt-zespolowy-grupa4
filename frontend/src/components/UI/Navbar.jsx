import {
    createStyles,
    Header,
    HoverCard,
    Group,
    Button,
    UnstyledButton,
    Text,
    SimpleGrid,
    ThemeIcon,
    Anchor,
    Image,
    Divider,
    Center,
    Box,
    Burger,
    Drawer,
    Collapse,
    ScrollArea, Modal
} from '@mantine/core';
import {useDisclosure} from '@mantine/hooks';
import {
    IconNotification,
    IconBook,
    IconDevices,
    IconGift,
    IconChartPie3,
    IconFingerprint,
    IconChevronDown
} from '@tabler/icons';
import Search from "./Search.jsx";
import CartModal from "./CartModal.jsx";
import BooklyLogo from "./BooklyLogo.jsx";
import {useLocation} from "react-router-dom";

const useStyles = createStyles((theme) => ({
    link: {
        display: 'flex',
        alignItems: 'center',
        height: '100%',
        paddingLeft: theme.spacing.md,
        paddingRight: theme.spacing.md,
        textDecoration: 'none',
        color: theme.colorScheme === 'dark' ? theme.white : theme.black,
        fontWeight: 500,
        fontSize: theme.fontSizes.sm,

        [theme.fn.smallerThan(1080)]: { 
            height: 42,
            display: 'flex',
            alignItems: 'center',
            width: '100%',
        },

        ...theme.fn.hover({
            backgroundColor: theme.colorScheme === 'dark' ? theme.colors.dark[6] : theme.colors.gray[0],
        }),
    },

    subLink: {
        width: '100%',
        padding: `${theme.spacing.xs}px ${theme.spacing.md}px`,
        borderRadius: theme.radius.md,

        ...theme.fn.hover({
            backgroundColor: theme.colorScheme === 'dark' ? theme.colors.dark[7] : theme.colors.gray[0],
        }),

        '&:active': theme.activeStyles,
    },

    dropdownFooter: {
        backgroundColor: theme.colorScheme === 'dark' ? theme.colors.dark[7] : theme.colors.gray[0],
        margin: -theme.spacing.md,
        marginTop: theme.spacing.sm,
        padding: `${theme.spacing.md}px ${theme.spacing.md * 2}px`,
        paddingBottom: theme.spacing.xl,
        borderTop: `1px solid ${
            theme.colorScheme === 'dark' ? theme.colors.dark[5] : theme.colors.gray[1]
        }`,
    },

    hiddenMobile: {
        [theme.fn.smallerThan(1080)]: { 
            display: 'none',
        },
    },

    hiddenDesktop: {
        [theme.fn.largerThan(1080)]: { 
            display: 'none',
        },
    },
}));

const mockdata = [
    {
        icon: IconBook,
        title: 'Books',
        description: 'Pick a Book from our vast library',
    },
    {
        icon: IconDevices,
        title: 'Digital Books',
        description: 'Digital - innovative, light, easy to read in any situation whenever you want',
    },
    {
        icon: IconGift,
        title: 'Souvenirs',
        description: 'Browse through some souvenirs - cups, plates with interesting prints and etc. ',
    },
    {
        icon: IconFingerprint,
        title: 'Security',
        description: 'Get an insight on you security status',
    },
    {
        icon: IconChartPie3,
        title: 'Analytics',
        description: 'Check out statistics and diagrams of ours newest researches',
    },
    {
        icon: IconNotification,
        title: 'Notifications',
        description: 'Check notifications that you have missed recently',
    },
];

export function Navbar() {
    const [drawerOpened, {toggle: toggleDrawer, close: closeDrawer}] = useDisclosure(false);
    const [cartOpened, {toggle: toggleCart, close: closeCart}] = useDisclosure(false);
    const [linksOpened, {toggle: toggleLinks}] = useDisclosure(false);
    const {classes, theme} = useStyles();

    const location = useLocation()
    console.log(location)

    const links = mockdata.map((item) => (
        <UnstyledButton className={classes.subLink} key={item.title}>
            <Group noWrap={true} align="flex-start">
                <ThemeIcon size={34} variant="default" radius="md">
                    <item.icon size={22} color={theme.fn.primaryColor()}/>
                </ThemeIcon>
                <div>
                    <Text size="sm" weight={500}>
                        {item.title}
                    </Text>
                    <Text size="xs" color="dimmed">
                        {item.description}
                    </Text>
                </div>
            </Group>
        </UnstyledButton>
    ));

    return (
        <>
            <Modal
                opened={cartOpened}
                onClose={closeCart}
                title="Your shopping cart"
                overlayColor={theme.colorScheme === 'dark' ? theme.colors.dark[9] : theme.colors.gray[2]}
                overlayOpacity={0.55}
                overlayBlur={3}
                exitTransitionDuration={300}
                overflow="inside"
            >
                <CartModal />
            </Modal>

            <Box pb={120}>
                <Header height={60} px="md">
                    <Group position="apart" sx={{height: '100%'}}>

                        <Anchor href="/" >
                            <BooklyLogo />
                        </Anchor>

                        <Search classes={location.pathname.match("login|signup") ? `${classes.hiddenDesktop} ${classes.hiddenMobile}`: ''} />
                        <Group sx={{height: '100%'}} spacing={0} className={classes.hiddenMobile}>
                            <a href="#" className={classes.link}>
                                Books
                            </a>
                            <a href="#" className={classes.link}>
                                Digital
                            </a>
                            <HoverCard width={600} position="bottom" radius="md" shadow="md" withinPortal>
                                <HoverCard.Target>
                                    <a href="#" className={classes.link}>
                                        <Center inline>
                                            <Box component="span" mr={5}>
                                                Products
                                            </Box>
                                            <IconChevronDown size={16} color={theme.fn.primaryColor()}/>
                                        </Center>
                                    </a>
                                </HoverCard.Target>

                                <HoverCard.Dropdown sx={{overflow: 'hidden'}}>
                                    <Group position="apart" px="md">
                                        <Text weight={500}>Features</Text>
                                        <Anchor href="#" size="xs">
                                            View all
                                        </Anchor>
                                    </Group>

                                    <Divider
                                        my="sm"
                                        mx="-md"
                                        color={theme.colorScheme === 'dark' ? 'dark.5' : 'gray.1'}
                                    />

                                    <SimpleGrid cols={2} spacing={0}>
                                        {links}
                                    </SimpleGrid>

                                    <div className={classes.dropdownFooter}>
                                        <Group position="apart">
                                            <div>
                                                <Text weight={500} size="sm" color='gray.5'>
                                                    Whoopsies...
                                                </Text>
                                                <Text size="xs" color="dimmed">
                                                    Have any questions or found a bug?
                                                </Text>
                                            </div>
                                            <Button component='a' href="/contacts" variant="default" >Contact us!</Button>
                                        </Group>
                                    </div>
                                </HoverCard.Dropdown>
                            </HoverCard>
                        </Group>

                        <Group className={classes.hiddenMobile}>
                            <Button onClick={toggleCart}>Cart</Button>
                            <Button component="a" href="/login" variant="default">Log in</Button>
                            <Button component="a" href="/signup">Sign up</Button>
                        </Group>

                        <Burger opened={drawerOpened} onClick={toggleDrawer} className={classes.hiddenDesktop}/>
                    </Group>
                </Header>

                <Drawer
                    opened={drawerOpened}
                    onClose={closeDrawer}
                    size="100%"
                    padding="md"
                    title="Navigation"
                    className={classes.hiddenDesktop}
                    zIndex={1000000}
                >
                    <ScrollArea sx={{height: 'calc(100vh - 60px)'}} mx="-md">
                        <Divider my="sm" color={theme.colorScheme === 'dark' ? 'dark.5' : 'gray.1'}/>

                        <a href="#" className={classes.link}>
                            Home
                        </a>
                        <UnstyledButton className={classes.link} onClick={toggleLinks}>
                            <Center inline>
                                <Box component="span" mr={5}>
                                    Features
                                </Box>
                                <IconChevronDown size={16} color={theme.fn.primaryColor()}/>
                            </Center>
                        </UnstyledButton>
                        <Collapse in={linksOpened} > {links} </Collapse>
                        <a href="#" className={classes.link}>
                            Learn
                        </a>
                        <a href="#" className={classes.link}>
                            Academy
                        </a>

                        <Divider my="sm" color={theme.colorScheme === 'dark' ? 'dark.5' : 'gray.1'}/>

                        <Group grow pb="md">
                            <Button color={theme.colors.dark[7]} mx={16} >Cart</Button>
                        </Group>
                        <Group position="center" grow pb="md" px="md">
                            {/*usrCnt.isLoggedIn ? Cart + LogOut*/}
                            <Button component="a" href="/login" variant="default">Log in</Button>
                            <Button component="a" href="/signup">Sign up</Button>
                        </Group>
                    </ScrollArea>
                </Drawer>
            </Box>
        </>
    );
}

export default Navbar;