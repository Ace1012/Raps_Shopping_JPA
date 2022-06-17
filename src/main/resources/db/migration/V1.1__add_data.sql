--Categories table data
INSERT INTO public.categories (name) VALUES
    ('detergents'),
    ('food'),
    ('spread'),
    ('spice')
    ON CONFLICT DO NOTHING;

--Items table data
INSERT INTO public.items (name, stock, category, price) VALUES
    ('Ariel', 2, 1, 200),
    ('Broadways', 3, 2, 55),
    ('Blue-Band', 1, 3, 100),
    ('Turmeric', 1, 4, 50),
    ('Black Pepper', 8, 4, 80)
    ON CONFLICT DO NOTHING;

--Users table data
INSERT INTO public.users (username, password) VALUES
    ('Tony', '$2a$04$8iqZbBY5U7vCw7Rf3ypBD.acuCw1huMzVJmD1ZHTQFxVEMrPXnIye'),
    ('Bob', '$2a$04$PLz5o2gVn/77FTuw.bdXNOTmII3ytLXnezod3Ab6Frih8Z0B.ts2m')
    ON CONFLICT DO NOTHING;

--Lists table data
INSERT INTO public.lists (shopping_month, list_date) VALUES
    ('January 2022', '2022-01-01'),
    ('February 2022', '2022-02-01'),
    ('March 2022', '2022-03-01'),
    ('April 2022', '2022-04-01'),
    ('May 2022', '2022-05-01'),
    ('June 2022', '2022-06-01'),
    ('July 2022', '2022-07-01'),
    ('August 2022', '2022-08-01'),
    ('September 2022', '2022-09-01'),
    ('October 2022', '2022-10-01'),
    ('November 2022', '2022-11-01'),
    ('December 2022', '2022-12-01')
    ON CONFLICT DO NOTHING;

--Lists_Items table data
INSERT INTO public.lists_items (list_id, item_id) VALUES
    (1, 1),
    (1, 2),
    (1, 3),
    (1,4),
    (1,5),
    (2, 1),
    (2, 2),
    (2, 3)
    ON CONFLICT DO NOTHING;