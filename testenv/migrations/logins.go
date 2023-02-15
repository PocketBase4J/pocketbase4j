package migrations

import (
	"github.com/pocketbase/dbx"
	"github.com/pocketbase/pocketbase/migrations"
)

func init() {
	migrations.Register(func(db dbx.Builder) error {
		// up queries...

		query := db.NewQuery("INSERT INTO `_admins` (`avatar`, `created`, `email`, `id`, `lastResetSentAt`, `passwordHash`, `tokenKey`, `updated`) VALUES (0, '2023-02-14 23:48:31.060Z', 'admin@example.org', '1p0n8xmaw3x9ygi', '', '$2a$13$vxgzLMua5S2p5DnV.jbY5uTuNn5f1Oc5PHe2o7cycSDUbtsSX.fwe', 'NaPoe6ItsiNaPqFasylPjju378pJUobmjG8ChYt0MuPkPIyHCb', '2023-02-14 23:48:31.060Z')")
		if _, err := query.Execute(); err != nil {
			return err
		}

		query = db.NewQuery("INSERT INTO `users` (`avatar`, `created`, `email`, `emailVisibility`, `id`, `lastResetSentAt`, `lastVerificationSentAt`, `name`, `passwordHash`, `tokenKey`, `updated`, `username`, `verified`) VALUES ('', '2023-02-14 23:49:01.474Z', 'user@example.org', false, '5qtr1u2fff00xs8', '', '', '', '$2a$13$85cl1pN5j/c2K.j1ZxLVdefI4McFwLCXWSt..2yZ/Lk5K7Zt7.d/y', 'p7iamT9YX4cSEd7yf2qSa0Y7twuzEE4f7cyAB2GrCcsHZJnnfw', '2023-02-14 23:49:01.474Z', 'users53547', true)")
		if _, err := query.Execute(); err != nil {
			return err
		}

		return nil
	}, func(db dbx.Builder) error {
		// down queries...

		return nil
	})
}
